import { Component, input, signal } from '@angular/core';
import { API_CONFIG } from '../../../constants/api.constants';

export type OAuthProvider = 'github' | 'google' | 'facebook';

interface ProviderConfig {
  id: OAuthProvider;
  name: string;
}

@Component({
  selector: 'app-oauth-buttons',
  templateUrl: './oauth-buttons.html',
  host: { class: 'block' },
})
export class OAuthButtons {
  readonly disabled = input<boolean>(false);
  readonly providers = input<OAuthProvider[]>(['github', 'google']);
  readonly dividerText = input<string>('or');

  protected readonly activeProvider = signal<OAuthProvider | null>(null);

  protected readonly allProviders: Record<OAuthProvider, ProviderConfig> = {
    github: { id: 'github', name: 'GitHub' },
    google: { id: 'google', name: 'Google' },
    facebook: { id: 'facebook', name: 'Facebook' },
  };

  protected onLogin(provider: OAuthProvider): void {
    if (this.disabled() || this.activeProvider()) return;
    this.activeProvider.set(provider);
    window.location.href = `${API_CONFIG.BASE_URL}${API_CONFIG.ENDPOINTS.OAUTH_AUTH}/${provider}`;
  }
}
