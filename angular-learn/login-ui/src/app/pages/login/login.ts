import { Component, inject, signal, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import {
  form,
  required,
  email,
  minLength,
  submit,
} from '@angular/forms/signals';
import { Auth } from '../../services/auth';
import { extractErrorMessage } from '../../shared/utils/error.util';
import { ButtonComponent } from '../../shared/components/button/button.component';
import { AuthLayout } from '../../shared/layouts/auth-layout/auth-layout';
import { InputComponent } from '../../shared/components/input/input';

@Component({
  selector: 'app-login',
  imports: [InputComponent, ButtonComponent, AuthLayout],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login implements OnInit {
  private readonly auth = inject(Auth);
  private readonly router = inject(Router);
  private readonly route = inject(ActivatedRoute);

  protected readonly isLoading = signal(false);
  protected readonly errorMessage = signal<string | null>(null);

  protected readonly credentialsModel = signal({
    userName: '',
    password: '',
  });

  protected readonly loginForm = form(this.credentialsModel, (f) => {
    required(f.userName, { message: 'Email address is required' });
    email(f.userName, { message: 'Please enter a valid email address' });
    required(f.password, { message: 'Password is required' });
    minLength(f.password, 4, {
      message: 'Password must be at least 4 characters long',
    });
  });

  ngOnInit(): void {
    const error = this.route.snapshot.queryParamMap.get('error');
    if (error) {
      this.errorMessage.set(extractErrorMessage(decodeURIComponent(error)));
    }
  }

  onSubmit(event: Event): void {
    event.preventDefault();

    submit(this.loginForm, async () => {
      if (this.isLoading()) return;

      this.isLoading.set(true);
      this.errorMessage.set(null);

      const { userName, password } = this.credentialsModel();

      try {
        await firstValueFrom(
          this.auth.loginWithCredentials({ userName, password })
        );
        this.router.navigate(['/home']);
      } catch (err: unknown) {
        this.errorMessage.set(
          extractErrorMessage(
            err,
            'Invalid credentials. Please verify your username and password.'
          )
        );
      } finally {
        this.isLoading.set(false);
      }
    });
  }
}
