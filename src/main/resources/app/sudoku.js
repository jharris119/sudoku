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
            return (
              <div id={`row${r}`}>{
                _.range(size).map((c) => {
                  return (
                    <SudokuCell row={r + 1} column={c + 1} size={size} />
                  );
                })}
              </div>
            );
          })
        }
      </div>
    );
  }
}
