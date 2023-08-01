import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderEstoqueComponent } from './header-estoque.component';

describe('HeaderEstoqueComponent', () => {
  let component: HeaderEstoqueComponent;
  let fixture: ComponentFixture<HeaderEstoqueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderEstoqueComponent]
    });
    fixture = TestBed.createComponent(HeaderEstoqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
