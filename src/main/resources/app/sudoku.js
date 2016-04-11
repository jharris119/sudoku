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
      boxesPerRow: cellsPerBoxColumn,
      boxesPerColumn: cellsPerBoxRow
    } = this.props;
    let size = cellsPerBoxRow * cellsPerBoxColumn;

    return (
      <div>
        {
          _.range(size).map((r) => {
            return _.range(size).map((c) => {
              return (<SudokuCell row={r} column={c} />);
            });
          })
        }
      </div>
    );
  }
}
