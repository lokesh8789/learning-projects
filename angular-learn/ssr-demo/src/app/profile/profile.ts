import { Component, inject } from '@angular/core';
import { PostService } from '../services/post-service';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  imports: [],
  selector: 'app-profile',
  styleUrl: './profile.css',
  templateUrl: './profile.html',
})
export class Profile {
  private postService = inject(PostService)

  posts = toSignal(this.postService.getPosts(), { initialValue: [] })
}
