import React from 'react';
import _ from 'lodash';

import SudokuCell from './sudokucell.js';

export default class Sudoku extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      givens: {},
      solution: null
    }
    _.bindAll(this, 'onUpdateCell');
  }

  onUpdateCell(row, column, digit) {
    let newGivens = Object.assign({}, this.state.givens);

    if (digit) {
      newGivens[this.key(row, column)] = digit;
    }
    else {
      delete newGivens[this.key(row, column)];
    }
    this.setState({
      givens: newGivens
    });
  }

  key(row, column) {
    return `${row},${column}`;
  }

  render() {
    let cell = (r, c) => {
      let row = r + 1,
          column = c + 1;

      if (this.state.solution) {
        return (
          <span className="cell"
                style={_.has(this.state.givens, this.key(row, column)) ? { color: 'indigo' } : void 0}>
            {this.state.solution[this.key(row, column)]}
          </span>
        );
      }
      else {
        return (
          <SudokuCell row={row}
                      column={column}
                      key={this.key(row, column)}
                      onUpdateCell={this.onUpdateCell} />
        );
      }
    }

    return (
      <div id="sudoku">
        {
          _.range(this.props.size).map((r) => {
            return (
              <div id={`row${r}`} key={`row${r}`}>{
                _.range(this.props.size).map((c) => {
                  return cell(r,c);
                })}
              </div>
            );
          })
        }
      </div>
    );
  }
}
