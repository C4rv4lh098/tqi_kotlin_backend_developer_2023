import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadCarrinhoComponent } from './read-carrinho.component';

describe('ReadCarrinhoComponent', () => {
  let component: ReadCarrinhoComponent;
  let fixture: ComponentFixture<ReadCarrinhoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReadCarrinhoComponent]
    });
    fixture = TestBed.createComponent(ReadCarrinhoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
