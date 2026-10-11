import { Component, input } from '@angular/core';

@Component({
  selector: 'app-button',
  host: { class: 'block' },
  template: `
    <button
      [type]="type()"
      [disabled]="disabled() || loading()"
      class="w-full py-2 px-4 rounded-md text-xs font-semibold transition cursor-pointer disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2 select-none"
      [class]="variantClasses()"
    >
      @if (loading()) {
        <svg class="animate-spin h-3.5 w-3.5 text-current" fill="none" viewBox="0 0 24 24">
          <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
          <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
        </svg>
        <span>{{ loadingText() || 'Please wait...' }}</span>
      } @else {
        <ng-content />
      }
    </button>
  `,
})
export class ButtonComponent {
  readonly type = input<'button' | 'submit' | 'reset'>('button');
  readonly loading = input<boolean>(false);
  readonly disabled = input<boolean>(false);
  readonly loadingText = input<string | null>(null);
  readonly variant = input<'primary' | 'secondary'>('primary');

  protected variantClasses(): string {
    if (this.variant() === 'secondary') {
      return 'bg-white hover:bg-slate-50 text-slate-700 border border-slate-300 shadow-sm';
    }
    return 'bg-blue-600 hover:bg-blue-700 text-white shadow-sm';
  }
}
