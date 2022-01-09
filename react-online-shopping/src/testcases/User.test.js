import { render, screen, fireEvent } from '@testing-library/react';
import TestUser from './User';

test("welcome Users!!",()=>{
    render(<TestUser/>)
    fireEvent.click(screen.getByText("View User Name"))
    screen.findAllByAltText("naren").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User Id"))
    screen.findAllByAltText("11").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User Password"))
    screen.findAllByAltText("naren123").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User Address"))
    screen.findAllByAltText("KTM").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User First Name"))
    screen.findAllByAltText("Naren").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User Last Name"))
    screen.findAllByAltText("Raval").then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })

    fireEvent.click(screen.getByText("View User Phone"))
    screen.findAllByAltText(987654321).then((e)=>{
        console.log(e)
        expect(e).toBeInTheDocument()
    })
})