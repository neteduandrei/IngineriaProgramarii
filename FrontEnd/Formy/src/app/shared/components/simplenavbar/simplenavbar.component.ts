import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth/auth.service';

@Component({
  selector: 'formy-simplenavbar',
  templateUrl: './simplenavbar.component.html',
  styleUrls: ['./simplenavbar.component.scss']
})
export class SimplenavbarComponent implements OnInit {

  constructor(private authService: AuthService) { }

  public logout() {
    this.authService.setLoginStatus(false);
  }

  ngOnInit() {
  }

}
