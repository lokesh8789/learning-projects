import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Auth } from '../../services/auth';
import { LoginResponse } from '../../models/auth.model';
import { extractErrorMessage } from '../../shared/utils/error.util';

@Component({
  selector: 'app-oauth-callback',
  imports: [],
  templateUrl: './oauth-callback.html',
  styleUrl: './oauth-callback.css',
})
export class OauthCallback implements OnInit {
  private readonly route = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly auth = inject(Auth);

  ngOnInit(): void {
    // 1. Read path variable: "success" or "failure"
    const status = this.route.snapshot.paramMap.get('status');
    const queryParams = this.route.snapshot.queryParamMap;

    // SUCCESS FLOW: /oauth/success?data=...
    if (status === 'success') {
      const dataParam = queryParams.get('data');

      if (dataParam) {
        try {
          const response: LoginResponse = JSON.parse(atob(dataParam));
          if (response.token) {
            this.auth.saveAuth(response.token, response.user);
            this.router.navigate(['/home'], { replaceUrl: true });
            return;
          }
        } catch (err) {
          console.error('Failed to parse OAuth Base64 payload', err);
        }
      }

      // Fallback for raw query params (?token=...&name=...)
      const token = queryParams.get('token');
      if (token) {
        const id = Number(queryParams.get('id')) || 0;
        const name = queryParams.get('name') || 'GitHub User';
        const email = queryParams.get('email') || '';

        this.auth.saveAuth(token, { id, name, email });
        this.router.navigate(['/home'], { replaceUrl: true });
        return;
      }
    }

    // FAILURE FLOW: /oauth/failure?error=...
    const rawError = queryParams.get('error') || queryParams.get('message');
    const errorMsg = extractErrorMessage(
      rawError,
      'GitHub authentication was cancelled or failed.'
    );

    this.router.navigate(['/login'], {
      queryParams: { error: errorMsg },
      replaceUrl: true,
    });
  }
}
