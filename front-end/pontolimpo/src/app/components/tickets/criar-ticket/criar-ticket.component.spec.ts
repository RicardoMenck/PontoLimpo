import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarTicketComponent } from './criar-ticket.component';

describe('CriarTicketComponent', () => {
  let component: CriarTicketComponent;
  let fixture: ComponentFixture<CriarTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CriarTicketComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CriarTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
