import React from 'react';
import { render } from 'react-dom';

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
          <input id="boxesPerRow" type="number" min="2" defaultValue="3" onChange={this.changeSize} />
          <label for="boxesPerRow">boxes per row</label>
          &times;
          <input id="boxesPerColumn" type="number" min="2" defaultValue="3" onChange={this.changeSize} />
          <label for="boxesPerColumn">boxes per column</label>
          <button id="solve">Solve</button>
        </div>
        <div id="sudoku">
          <Sudoku boxesPerRow={boxesPerRow} boxesPerColumn={boxesPerColumn} />
        </div>
      </div>
    );
  }
}

render(<SudokuApp />, document.getElementById('app'));
