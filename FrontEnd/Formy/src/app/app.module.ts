import 'hammerjs';

import {NgModule} from "@angular/core";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './components/authentification/authentification.component';
import { UserFormsComponent } from './components/user-forms/user-forms.component';
import { EditPasswordComponent } from "./components/edit-password/edit-password.component";
import { FillFormComponent } from './components/fill-form/fill-form.component';
import { NavbarComponent } from './shared/components/navbar/navbar.component';
import { FieldComponent } from "./components/build-form/field/field.component";
import { BuildFormComponent } from "./components/build-form/build-form.component";
import { FieldOfTypeComponent } from './components/build-form/field/field-of-type/field-of-type.component';
import { TypeShortTextComponent } from './components/build-form/field/field-of-type/type-short-text/type-short-text.component';
import { TypeLongTextComponent } from './components/build-form/field/field-of-type/type-long-text/type-long-text.component';
import { TypeSingleChoiceComponent } from './components/build-form/field/field-of-type/type-single-choice/type-single-choice.component';
import { TypeMultipleChoiceComponent } from './components/build-form/field/field-of-type/type-multiple-choice/type-multiple-choice.component';
import { TypeDateComponent } from './components/build-form/field/field-of-type/type-date/type-date.component';
import { TypeLinearScaleComponent } from './components/build-form/field/field-of-type/type-linear-scale/type-linear-scale.component';
import { FormPreviewComponent } from './components/user-forms/form-preview/form-preview.component';
import { DialogShareComponent } from './components/user-forms/form-preview/dialogs/dialog-share.component';
import { DialogDeleteComponent } from './components/edit-password/edit-password.component';
import { ClipboardModule } from 'ngx-clipboard';
import {NgxChartsModule} from '@swimlane/ngx-charts';

import {FillFormService} from "app/shared/services/fill-form/fill-form.service";
import { FillFieldComponent } from './components/fill-form/fill-field/fill-field.component';
import { FillFieldOfTypeComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-field-of-type.component';
import { FillTypeDateComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-date/fill-type-date.component';
import { FillTypeLinearScaleComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-linear-scale/fill-type-linear-scale.component';
import { FillTypeLongTextComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-long-text/fill-type-long-text.component';
import { FillTypeMultipleChoiceComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-multiple-choice/fill-type-multiple-choice.component';
import { FillTypeShortTextComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-short-text/fill-type-short-text.component';
import { FillTypeSingleChoiceComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-single-choice/fill-type-single-choice.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { SimplenavbarComponent } from './shared/components/simplenavbar/simplenavbar.component';

import {BuildFormService} from "./shared/services/build-form/build-form.service";
import {AuthService} from "./shared/services/auth/auth.service";
import {FormsService} from "./shared/services/forms/forms.service";

import { AnswersFormComponent } from './components/answers-form/answers-form.component';
import { AnswerAbstractComponent } from './components/answers-form/answer-type/answer-abstract/answer-abstract.component';
import { AnswerTextComponent } from './components/answers-form/answer-type/answer-text/answer-text.component';
import { AnswerLinearScaleComponent } from './components/answers-form/answer-type/answer-linear-scale/answer-linear-scale.component';
import { AnswerDateComponent } from './components/answers-form/answer-type/answer-date/answer-date.component';
import { AnswerSingleChoiceComponent } from './components/answers-form/answer-type/answer-single-choice/answer-single-choice.component';
import { AnswerMultipleChoiceComponent } from './components/answers-form/answer-type/answer-multiple-choice/answer-multiple-choice.component';
import {QuestionsService} from './shared/services/questions/questions.service';
import {FileDropDirective, FileSelectDirective} from 'ng2-file-upload';




@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    DialogDeleteComponent,
    DialogShareComponent,
    EditPasswordComponent,
    UserFormsComponent,
    FillFormComponent,
    NavbarComponent,
    FieldComponent,
    BuildFormComponent,
    FieldOfTypeComponent,
    TypeShortTextComponent,
    TypeLongTextComponent,
    TypeSingleChoiceComponent,
    TypeMultipleChoiceComponent,
    TypeDateComponent,
    TypeLinearScaleComponent,
    FormPreviewComponent,
    FillFieldComponent,
    FillFieldOfTypeComponent,
    FillTypeDateComponent,
    FillTypeLinearScaleComponent,
    FillTypeLongTextComponent,
    FillTypeMultipleChoiceComponent,
    FillTypeShortTextComponent,
    FillTypeSingleChoiceComponent,
    EditProfileComponent,
    SimplenavbarComponent,
    AnswersFormComponent,
    AnswerAbstractComponent,
    AnswerTextComponent,
    AnswerLinearScaleComponent,
    AnswerDateComponent,
    AnswerSingleChoiceComponent,
    AnswerMultipleChoiceComponent,
    FileSelectDirective,
    FileDropDirective,
  ],
  imports: [
    AppRoutingModule,
    ClipboardModule,
    NgxChartsModule
  ],
  providers: [
    FillFormService,
    BuildFormService,
    AuthService,
    FormsService,
    QuestionsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
