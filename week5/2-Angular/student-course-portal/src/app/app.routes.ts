import { Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { CoursesComponent } from './courses/courses.component';

export const routes: Routes = [
  { path: '', redirectTo: '/students', pathMatch: 'full' },
  { path: 'students', component: StudentsComponent },
  { path: 'courses', component: CoursesComponent }
];
