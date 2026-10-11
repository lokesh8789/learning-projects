import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  private readonly auth = inject(Auth);
  private readonly router = inject(Router);

  protected readonly user = this.auth.currentUser;

  logout() {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
