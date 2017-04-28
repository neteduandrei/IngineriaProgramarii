import { FormyPage } from './app.po';

describe('formy App', () => {
  let page: FormyPage;

  beforeEach(() => {
    page = new FormyPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('formy works!');
  });
});
