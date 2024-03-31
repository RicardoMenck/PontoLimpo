import { Component } from '@angular/core';
import { tokenGetter } from './app.module';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pontolimpo';

  logged() {
    const tokenJWT = tokenGetter();
    return tokenJWT != null;
  }
}
