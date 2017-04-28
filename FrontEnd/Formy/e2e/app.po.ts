import { browser, element, by } from 'protractor';

export class FormyPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('formy-root h1')).getText();
  }
}
