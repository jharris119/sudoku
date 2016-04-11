import React from 'react';
import { render } from 'react-dom';
import { Button, Input } from 'react-bootstrap';

import Sudoku from './sudoku.js'

export default class SudokuApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      boxesPerRow: 3,
      boxesPerColumn: 3
    };
  }

  changeSize() {
    this.setState({
      boxesPerRow: document.findElementById('boxesPerRow').value,
      boxesPerColumn: document.findElementById('boxesPerColumn').value
    });
  }

  render() {
    let {
      boxesPerRow,
      boxesPerColumn
    } = this.state;

    return (
      <div>
        <div id="form">
          <Input type="number"
                 id="boxesPerRow"
                 label="boxes per row"
                 min="2"
                 defaultValue="3"
                 onChange={this.changeSize} />
          &times;
          <Input type="number"
                 id="boxesPerColumn"
                 label="boxes per column"
                 min="2"
                 defaultValue="3"
                 onChange={this.changeSize} />
          <Button id="solve" bsStyle="primary">Solve</Button>
        </div>
        <div id="sudoku">
          <Sudoku boxesPerRow={boxesPerRow} boxesPerColumn={boxesPerColumn} />
        </div>
      </div>
    );
  }
}

render(<SudokuApp />, document.getElementById('app'));
