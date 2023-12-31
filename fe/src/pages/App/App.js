import React from 'react';
import { Header } from '../../components';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Login, Survey, SurveyList, UsersManager, PersonalAccount} from '../'

function App () {
        return (
                <Router>
                    <Header></Header>

                    <Routes>
                        
                        <Route path="/login" element={<Login/>}/>

                        <Route path="/home" element={<SurveyList/>}/>

                        <Route path="/user/:userId" element={<PersonalAccount/>}/>

                        <Route path="/survey/:surveyId" element={<Survey/>}/>

                        <Route path="/users" element={<UsersManager/>}/>
                        
                        <Route path="/survey" element={<SurveyList/>}/>

                    </Routes>
                </Router>
    )
}

export { App }