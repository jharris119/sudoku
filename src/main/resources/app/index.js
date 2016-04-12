import React from 'react';
import { render } from 'react-dom';
import { Button, Grid, Row, Col, Input, Panel } from 'react-bootstrap';
import Radium from 'radium';

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
      <Panel className="wrapper" style={styles.panel}>
        <Grid style={styles.grid}>
          <Row>
            <Col xs={4}>
              <Input type="number"
                     id="boxesPerRow"
                     label="boxes per row"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col xs={1}>
              &times;
            </Col>
            <Col xs={4}>
              <Input type="number"
                     id="boxesPerColumn"
                     label="boxes per column"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col xs={3}>
              <Button id="solve" bsStyle="primary">Solve</Button>
            </Col>
          </Row>
        </Grid>
        <div id="sudoku">
          <Sudoku boxesPerRow={boxesPerRow} boxesPerColumn={boxesPerColumn} />
        </div>
      </Panel>
    );
  }
}

const styles = {
  panel: {
    width: '768px',
    position: 'fixed',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    padding: 'none',
    border: 'none'
  },
  grid: {
    width: '100%',
    border: '1px solid black',
    marginBottom: '10px'
  }
}

SudokuApp = Radium(SudokuApp);

render(<SudokuApp />, document.getElementById('app'));
