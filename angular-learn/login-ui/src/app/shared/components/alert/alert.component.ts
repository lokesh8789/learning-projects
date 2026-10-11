import { Component, input } from '@angular/core';

@Component({
  selector: 'app-alert',
  host: { class: 'block' },
  template: `
    @if (message()) {
      <div
        role="alert"
        class="p-2.5 text-xs rounded border"
        [class]="typeClasses()"
      >
        {{ message() }}
      </div>
    }
  `,
})
export class AlertComponent {
  readonly message = input<string | null>(null);
  readonly type = input<'error' | 'success' | 'info'>('error');

  protected typeClasses(): string {
    switch (this.type()) {
      case 'success':
        return 'text-green-700 bg-green-50 border-green-200';
      case 'info':
        return 'text-blue-700 bg-blue-50 border-blue-200';
      case 'error':
      default:
        return 'text-red-700 bg-red-50 border-red-200';
    }
  }
}
