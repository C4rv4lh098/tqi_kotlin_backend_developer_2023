import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatClientesComponent } from './creat-clientes.component';

describe('CreatClientesComponent', () => {
  let component: CreatClientesComponent;
  let fixture: ComponentFixture<CreatClientesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatClientesComponent]
    });
    fixture = TestBed.createComponent(CreatClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
