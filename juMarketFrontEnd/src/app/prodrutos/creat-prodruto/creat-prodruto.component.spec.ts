import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatProdrutoComponent } from './creat-prodruto.component';

describe('CreatProdrutoComponent', () => {
  let component: CreatProdrutoComponent;
  let fixture: ComponentFixture<CreatProdrutoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatProdrutoComponent]
    });
    fixture = TestBed.createComponent(CreatProdrutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
