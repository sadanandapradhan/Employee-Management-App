
import './App.css'
import HeaderComponent from './Components/HeaderComponent'
import ListEmployeeComponent from './Components/ListEmployeeComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeComponent from './Components/EmployeeComponent'
import ListDepartmentComponent from './Components/ListDepartmentComponent'
import DepartmentComponent from './Components/DepartmentComponent'
function App() {


  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* http://localhost:3000 */}
          <Route path='/' element={<ListEmployeeComponent />}></Route>

          {/* http://localhost:3000/employees */}
          <Route path='/employees' element={<ListEmployeeComponent />}></Route>

          {/* http://localhost:3000/add-employees */}
          <Route path='/add-employee' element={<EmployeeComponent />}></Route>

          {/* http://localhost:3000/edit-employees/1 */}
          <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>

          {/* http://localhost:3000/departments */}
          <Route path='/departments/' element={<ListDepartmentComponent />}></Route>

           {/* http://localhost:3000/add-departments */}
          <Route path='/add-department/' element={<DepartmentComponent />}></Route>

          <Route path='/edit-department/:id' element={<DepartmentComponent/>}></Route>


        </Routes>
        <FooterComponent />
      </BrowserRouter>

    </>
  )
}

export default App
