import { Service, signal, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import {
  User,
  RegisterPayload,
  RegisterResponse,
  LoginPayload,
  LoginResponse,
} from '../models/auth.model';
import { API_CONFIG, STORAGE_KEYS } from '../constants/api.constants';

@Service()
export class Auth {
  private readonly http = inject(HttpClient);
  private readonly apiBase = API_CONFIG.BASE_URL;

  readonly currentUser = signal<User | null>(this.getStoredUser());
  readonly token = signal<string | null>(this.getStoredToken());

  register(payload: RegisterPayload): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(
      `${this.apiBase}${API_CONFIG.ENDPOINTS.REGISTER}`,
      payload
    );
  }

  loginWithCredentials(payload: LoginPayload): Observable<LoginResponse> {
    return this.http
      .post<LoginResponse>(
        `${this.apiBase}${API_CONFIG.ENDPOINTS.LOGIN}`,
        payload
      )
      .pipe(
        tap((res) => {
          this.saveAuth(res.token, res.user);
        })
      );
  }

  saveAuth(token: string, user?: User): void {
    localStorage.setItem(STORAGE_KEYS.AUTH_TOKEN, token);
    this.token.set(token);

    if (user) {
      localStorage.setItem(STORAGE_KEYS.AUTH_USER, JSON.stringify(user));
      this.currentUser.set(user);
    }
  }

  logout(): void {
    localStorage.removeItem(STORAGE_KEYS.AUTH_TOKEN);
    localStorage.removeItem(STORAGE_KEYS.AUTH_USER);
    this.token.set(null);
    this.currentUser.set(null);
  }


  private getStoredToken(): string | null {
    return localStorage.getItem(STORAGE_KEYS.AUTH_TOKEN);
  }

  private getStoredUser(): User | null {
    const raw = localStorage.getItem(STORAGE_KEYS.AUTH_USER);
    if (!raw) return null;
    try {
      return JSON.parse(raw) as User;
    } catch {
      return null;
    }
  }
}
