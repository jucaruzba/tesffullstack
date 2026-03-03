import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PersonService } from '../../service/person.service';
import { Person } from '../../models/person.model';

@Component({
  selector: 'app-person-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './person-list.component.html',
})
export class PersonListComponent implements OnInit {
  persons: Person[] = [];

  constructor(private personService: PersonService) {}

  ngOnInit(): void {
    this.obtenerPersonas();
  }

  obtenerPersonas(): void {
    this.personService.consultarTodos().subscribe({
      next: (data) => (this.persons = data),
      error: (err) => console.error('Error al cargar personas', err),
    });
  }

  deletePerson(id: number): void {
    if (confirm('¿Deseas eliminar este registro?')) {
      this.personService.eliminar(id).subscribe(() => {
        this.obtenerPersonas();
      });
    }
  }
}
