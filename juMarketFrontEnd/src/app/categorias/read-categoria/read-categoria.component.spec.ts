import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadCategoriaComponent } from './read-categoria.component';

describe('ReadCategoriaComponent', () => {
  let component: ReadCategoriaComponent;
  let fixture: ComponentFixture<ReadCategoriaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReadCategoriaComponent]
    });
    fixture = TestBed.createComponent(ReadCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
