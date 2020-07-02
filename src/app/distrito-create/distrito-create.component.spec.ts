import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistritoCreateComponent } from './distrito-create.component';

describe('DistritoCreateComponent', () => {
  let component: DistritoCreateComponent;
  let fixture: ComponentFixture<DistritoCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistritoCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistritoCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
