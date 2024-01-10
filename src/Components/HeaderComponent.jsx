import React from 'react'
import { NavLink } from 'react-router-dom'

const HeaderComponent = () => {
  return (
    <div>
      <header>
        <nav className='navbar navbar-expand-lg bg-primary border-bottom border-body'>
          <a className="navbar-brand" href="https://www.google.com">EMPLOYEE MANAGEMENT SYSTEM</a>

          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
              <li className='nav-item'>
              <NavLink className='nav-link' to='/employees'>EMPLOYEE</NavLink>
              </li>

              <li className='nav-item'>
              <NavLink className='nav-link' to='/departments'>DEPARTMENTS</NavLink>
              </li>
            </div>
          </div>

        </nav>

      </header>
    </div>
  )
}

export default HeaderComponent