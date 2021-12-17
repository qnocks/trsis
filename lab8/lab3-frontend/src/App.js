import './App.css';
import { Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';

import IndexComponent from './components/IndexComponent';

import DoctorComponent from './components/doctors/DoctorComponent';
import CreateDoctorComponent from './components/doctors/CreateDoctorComponent';

import PatientComponent from './components/patients/PatientComponent';
import CreatePatientComponent from './components/patients/CreatePatientComponent';

import AppointmentComponent from './components/appointments/AppointmentComponent';
import CreateAppointmentComponent from './components/appointments/CreateAppointmentComponent';

function App() {
  return (
    <BrowserRouter>
      <div className="app-wrapper background-color">
        <IndexComponent />
      </div>
      <div className='app-wrapper-content'>
        <Route path='/doctors' exact component={DoctorComponent} />
        <Route path='/doctors/create' component={CreateDoctorComponent} />
        <Route path='/patients' exact component={PatientComponent} />
        <Route path='/patients/create' component={CreatePatientComponent} />
        <Route path='/appointments' exact component={AppointmentComponent} />
        <Route path='/appointments/create' component={CreateAppointmentComponent} />
      </div>
    </BrowserRouter>

  );
}

export default App;
