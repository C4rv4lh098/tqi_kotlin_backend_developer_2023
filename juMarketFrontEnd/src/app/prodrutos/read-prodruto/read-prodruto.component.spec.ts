import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadProdrutoComponent } from './read-prodruto.component';

describe('ReadProdrutoComponent', () => {
  let component: ReadProdrutoComponent;
  let fixture: ComponentFixture<ReadProdrutoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReadProdrutoComponent]
    });
    fixture = TestBed.createComponent(ReadProdrutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
