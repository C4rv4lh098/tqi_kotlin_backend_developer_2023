import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCompraComponent } from './header-compra.component';

describe('HeaderCompraComponent', () => {
  let component: HeaderCompraComponent;
  let fixture: ComponentFixture<HeaderCompraComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderCompraComponent]
    });
    fixture = TestBed.createComponent(HeaderCompraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
