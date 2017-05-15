import { Injectable } from '@angular/core';
import {FormReceiveTemplate} from '../../../shared/modelsV2/FormReceiveTemplate';

@Injectable()
export class ShareFormEditableService {

  public form : FormReceiveTemplate;

  constructor() {
    this.form = new FormReceiveTemplate;
  }

}
