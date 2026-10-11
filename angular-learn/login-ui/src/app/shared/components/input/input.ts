import { Component, computed, input, signal } from '@angular/core';
import { FormField, Field } from '@angular/forms/signals';

let nextId = 0;

@Component({
  selector: 'app-input',
  imports: [FormField],
  templateUrl: './input.html',
  host: { class: 'block' },
})
export class InputComponent {
  readonly id = input<string>('');
  readonly name = input<string>('');
  readonly label = input<string>('');
  readonly type = input<string>('text');
  readonly placeholder = input<string>('');
  readonly autocomplete = input<string>('');
  readonly disabled = input<boolean>(false);
  readonly hint = input<string>('');
  readonly field = input<Field<any> | null>(null);

  private readonly autoId = `app-input-${++nextId}`;
  protected readonly inputId = computed(() => this.id() || this.autoId);

  protected readonly inputClasses = computed(() => {
    const base = 'w-full px-3 py-2 bg-white border rounded-md text-sm text-slate-900 placeholder:text-slate-400 focus:outline-none focus:ring-2 transition disabled:bg-slate-50 disabled:text-slate-400 disabled:cursor-not-allowed';
    const padding = this.type() === 'password' ? 'pr-14' : '';
    const state = this.isInvalid()
      ? 'border-red-400 focus:border-red-500 focus:ring-red-500/20'
      : 'border-slate-300 focus:border-blue-600 focus:ring-blue-500/20';
    return `${base} ${padding} ${state}`.trim();
  });

  protected readonly showPassword = signal(false);

  protected readonly effectiveType = computed(() => {
    if (this.type() === 'password') {
      return this.showPassword() ? 'text' : 'password';
    }
    return this.type();
  });

  protected readonly isInvalid = computed(() => {
    const fieldRef = this.field();
    if (!fieldRef) return false;
    const state = fieldRef();
    return state.touched() && state.invalid();
  });

  protected readonly errorMessage = computed(() => {
    const fieldRef = this.field();
    if (!fieldRef) return null;
    const errors = fieldRef().errors();
    return errors && errors.length > 0 ? errors[0]?.message : null;
  });

  protected togglePasswordVisibility(): void {
    this.showPassword.update((val) => !val);
  }
}
