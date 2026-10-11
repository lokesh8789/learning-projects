import { Component, computed, input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { AlertComponent } from '../../components/alert/alert.component';
import { OAuthButtons } from '../../components/oauth-buttons/oauth-buttons';

export type AuthType = 'login' | 'register' | 'forgot-password';

@Component({
  selector: 'app-auth-layout',
  imports: [RouterLink, AlertComponent, OAuthButtons],
  templateUrl: './auth-layout.html',
})
export class AuthLayout {
  readonly type = input<AuthType>('login');
  readonly title = input<string>('');
  readonly subtitle = input<string>('');
  readonly errorMessage = input<string | null>(null);
  readonly isLoading = input<boolean>(false);
  readonly showOAuth = input<boolean | undefined>(undefined);

  protected readonly shouldShowOAuth = computed(() => {
    if (this.showOAuth() !== undefined) {
      return this.showOAuth();
    }
    return this.type() === 'login' || this.type() === 'register';
  });
}

