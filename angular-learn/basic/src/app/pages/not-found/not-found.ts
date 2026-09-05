import { Component, inject, input, output } from '@angular/core';
import { Router, RouterLink } from "@angular/router";

@Component({
  imports: [RouterLink],
  selector: 'app-not-found',
  styleUrl: './not-found.css',
  templateUrl: './not-found.html',
})
export class NotFound {
  router = inject(Router);

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
