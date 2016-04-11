import React from 'react';

export default class SudokuCell extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (<input id={`cell[${this.props.row},${this.props.column}]`} type="text" />);
  }
}
