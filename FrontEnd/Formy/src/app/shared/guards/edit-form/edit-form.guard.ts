import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {BuildFormService} from '../../services/build-form/build-form.service';
import {ShareFormEditableService} from 'app/components/edit-form/services/share-form-editable.service';
import {Http} from '@angular/http';
import {FormsService} from 'app/shared/services/forms/forms.service';

@Injectable()
export class EditFormGuard implements CanActivate {

  private id : string;

  constructor(
    private buildFormService : BuildFormService,
    private shareFormEditableService : ShareFormEditableService,
    private formsService : FormsService,
    private router: Router
  ){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
    console.log('guard activated');
    this.id = route.paramMap.get('id');
    console.log(this.buildFormService.formReceiveTemplate);
    if(this.buildFormService.formReceiveTemplate != null) {
      if (this.buildFormService.formReceiveTemplate.id == this.id) {
        this.shareFormEditableService.form = this.buildFormService.getFormTemplate();
        console.log('se pare ca era deja');
        return true;
      }
    } else {
      let result : boolean = false;
      this.formsService.getFromById(this.id)
        .subscribe((response) => {
            this.shareFormEditableService.form = response;
            console.log('received from server');
            console.log(response);
            result = true;
          },
          (err) => {
            console.log('eroare');
            console.log(err);
            result = false;
          });
      if(result === false) {
        this.router.navigate(['']);
      }
      return result;
    }
  }

}
