import { Component, OnInit } from '@angular/core';
import { CommonModule, formatDate } from '@angular/common'; // Importamos formatDate
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { PersonService } from '../../service/person.service';

@Component({
  selector: 'app-person-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './person-form.component.html'
})
export class PersonFormComponent implements OnInit {
  personForm: FormGroup;
  isEdit: boolean = false;
  personId?: number;

  constructor(
    private fb: FormBuilder,
    private personService: PersonService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.personForm = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      apellido: ['', [Validators.required]],
      fechaNacimiento: ['', [Validators.required]], 
      puesto: [''],
      sueldo: [0, [Validators.min(0)]]
    });
  }

  ngOnInit(): void {
    this.personId = this.route.snapshot.params['id'];
    if (this.personId) {
      this.isEdit = true;
      this.personService.consultarPorId(this.personId).subscribe({
        next: (data) => {
          const dateParts = data.fechaNacimiento.split('-');
          const dateForInput = `${dateParts[2]}-${dateParts[1]}-${dateParts[0]}`;
          
          this.personForm.patchValue({
            ...data,
            fechaNacimiento: dateForInput
          });
        }
      });
    }
  }

  save(): void {
    if (this.personForm.invalid) return;

    const rawValue = this.personForm.value;
    
    const formattedDate = formatDate(rawValue.fechaNacimiento, 'dd-MM-yyyy', 'en-US');

    const personData = {
      ...rawValue,
      id: this.personId,
      fechaNacimiento: formattedDate
    };

    const request = this.isEdit 
      ? this.personService.actualizar(personData) 
      : this.personService.guardar(personData);

    request.subscribe(() => this.router.navigate(['/persons']));
  }
}