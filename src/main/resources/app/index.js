import React from 'react';
import { render } from 'react-dom';
import { Button, Grid, Row, Col, Input, Panel } from 'react-bootstrap';
import _ from 'lodash';
import $ from 'jquery';

import Sudoku from './sudoku.js';

require('../styles/style.scss');
require('../styles/dummy.scss');

const dummyStylesheet = document.styleSheets[document.styleSheets.length - 1];

export default class SudokuApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      boxesPerRow: 3,
      boxesPerColumn: 3
    };
    _.bindAll(this, 'changeSize');
  }

  componentDidMount() {
    this.updateStylesheet();
  }

  componentDidUpdate(prevProps, prevState) {
    this.updateStylesheet();
  }

  changeSize() {
    if (document.getElementById('boxesPerRow').value && document.getElementById('boxesPerColumn').value) {
      this.setState({
        boxesPerRow: document.getElementById('boxesPerRow').value,
        boxesPerColumn: document.getElementById('boxesPerColumn').value
      });
    }
  }

  clearStylesheet() {
    while (dummyStylesheet.rules.length) {
      dummyStylesheet.deleteRule(0);
    }
  }

  updateStylesheet() {
    this.clearStylesheet();

    let containerWidth = $('#sudoku').width();
    let cellWidth = ((((containerWidth - 5) / this.state.boxesPerRow) - 4) / this.state.boxesPerColumn) - 2;

    let verticalRule = `.cell:nth-child(${this.state.boxesPerRow}n) { border-right: 5px solid black; }`,
        horizontalRule = `#sudoku :nth-child(${this.state.boxesPerColumn}n) .cell { border-bottom: 5px solid black; }`,
        widthRule = `.cell { width: ${Math.floor(cellWidth)}px; }`,
        heightRule = `.cell { height: ${Math.floor(cellWidth)}px; }`;

    dummyStylesheet.insertRule(verticalRule, 0);
    dummyStylesheet.insertRule(horizontalRule, 0);
    dummyStylesheet.insertRule(widthRule, 0);
    dummyStylesheet.insertRule(heightRule, 0);
  }

  render() {
    let {
      boxesPerRow,
      boxesPerColumn
    } = this.state;

    return (
      <Panel className="wrapper">
        <Grid id="button-container">
          <Row>
            <Col style={{marginRight: '6px'}}>
              <Input type="number"
                     id="boxesPerRow"
                     label="boxes per row"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col>
              &times;
            </Col>
            <Col style={{marginLeft: '6px'}}>
              <Input type="number"
                     id="boxesPerColumn"
                     label="boxes per column"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col>
              <Button id="solve" bsStyle="primary">Solve</Button>
            </Col>
          </Row>
        </Grid>
        <Sudoku size={boxesPerRow * boxesPerColumn} />
      </Panel>
    );
  }
}

render(<SudokuApp />, document.getElementById('app'));
