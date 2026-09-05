import { Component, signal, effect, computed, inject } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { Header } from "./shared/header/header";

@Component({
  imports: [RouterOutlet, Header],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('A Basic App');
  router = inject(Router);

  goToProfile() {
    this.router.navigate(["/profile/2635"])
  }
}
