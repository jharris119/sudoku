import React from 'react';
import $ from 'jquery';

export default class SudokuCell extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="cell">
        <input style={{width: '100%', height: '100%', border: 'none'}} id={`cell[${this.props.row},${this.props.column}]`} type="text" />
      </div>
    );
  }
}
