import React from 'react';
import _ from 'lodash';

import SudokuCell from './sudokucell.js';

export default class Sudoku extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      solved: false
    }
  }

  render() {
    let {
      cellsPerBoxRow: boxesPerColumn,
      cellsPerBoxColumn: boxesPerRow
    } = this.props;

    return (<SudokuCell />);
  }
}
