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

  render() {
    let {
      boxesPerRow,
      boxesPerColumn
    } = this.state;

    return (<Sudoku boxesPerRow={boxesPerRow} boxesPerColumn={boxesPerColumn} />);
  }
}

render(<SudokuApp />, document.getElementById('app'));
