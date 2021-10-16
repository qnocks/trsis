import logo from './logo.svg';
import './App.css';
import { Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';

import IndexComponent from './components/IndexComponent';

import DoctorComponent from './components/doctors/DoctorComponent';
import CreateDoctorComponent from './components/doctors/CreateDoctorComponent';

import PatientComponent from './components/patients/PatientComponent';


function App() {
  return (
    <BrowserRouter>
      <div className="app-wrapper">
        <IndexComponent />
      </div>
      <div className='app-wrapper-content'>
        <Route path='/doctors' exact component={DoctorComponent} />
        <Route path='/doctors/create' component={CreateDoctorComponent} />
        <Route path='/patients' component={PatientComponent} />
      </div>
    </BrowserRouter>

  );
}

export default App;
