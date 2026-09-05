import { Component, input, output } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-header',
  styleUrl: './header.css',
  templateUrl: './header.html',
})
export class Header {
  title = input<string>();
  goProfile = output<void>();

  goToProfile() {
    this.goProfile.emit()
  }
}
