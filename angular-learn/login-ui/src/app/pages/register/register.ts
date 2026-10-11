import { Component, inject, signal } from '@angular/core';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import {
  form,
  required,
  email,
  minLength,
  validate,
  submit,
} from '@angular/forms/signals';
import { Auth } from '../../services/auth';
import { extractErrorMessage } from '../../shared/utils/error.util';
import { ButtonComponent } from '../../shared/components/button/button.component';
import { AuthLayout } from '../../shared/layouts/auth-layout/auth-layout';
import { InputComponent } from '../../shared/components/input/input';

@Component({
  selector: 'app-register',
  imports: [InputComponent, ButtonComponent, AuthLayout],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  private readonly auth = inject(Auth);
  private readonly router = inject(Router);

  protected readonly isLoading = signal(false);
  protected readonly errorMessage = signal<string | null>(null);

  protected readonly userModel = signal({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  protected readonly registerForm = form(this.userModel, (f) => {
    required(f.name, { message: 'Full name is required' });
    minLength(f.name, 2, { message: 'Name must be at least 2 characters' });

    required(f.email, { message: 'Email address is required' });
    email(f.email, { message: 'Please enter a valid email address' });

    required(f.password, { message: 'Password is required' });
    minLength(f.password, 8, {
      message: 'Password must be at least 8 characters long',
    });

    required(f.confirmPassword, { message: 'Please confirm your password' });
    validate(f.confirmPassword, ({ value }) => {
      if (value() && value() !== this.userModel().password) {
        return {
          kind: 'passwordMismatch',
          message: 'Passwords do not match',
        };
      }
      return undefined;
    });
  });

  onSubmit(event: Event): void {
    event.preventDefault();

    submit(this.registerForm, async () => {
      if (this.isLoading()) return;

      this.isLoading.set(true);
      this.errorMessage.set(null);

      const { name, email, password } = this.userModel();

      try {
        await firstValueFrom(
          this.auth.register({ name, email, password })
        );
        this.router.navigate(['/login']);
      } catch (err: unknown) {
        this.errorMessage.set(
          extractErrorMessage(
            err,
            'Registration failed. Please check your details and try again.'
          )
        );
      } finally {
        this.isLoading.set(false);
      }
    });
  }
}
