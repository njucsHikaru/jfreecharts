package chart;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

import util.ChartUtils;

/**
 * 
 * @author ccw
 * @date 2014-6-11
 *       <p>
 *       ����ͼ���裺<br/>
 *       1���������ݼ���<br/>
 *       2������Chart��<br/>
 *       3:���ÿ���ݣ���ֹ������ʾ�����<br/>
 *       4:�����ӽ�����Ⱦ��<br/>
 *       5:���������ֽ�����Ⱦ<br/>
 *       6:ʹ��chartPanel����<br/>
 * 
 *       </p>
 */
public class PieChart {
	public PieChart() {
	}

	public DefaultPieDataset createDataset() {
		String[] categories = { "Bananas", "Kiwi", "Mixed nuts", "Oranges", "Apples", "Pears", "Clementines", "Reddish (bag)", "Grapes (bunch)", };
		Object[] datas = { 8, 3, 1, 6, 8, 4, 4, 1, 1 };
		DefaultPieDataset dataset = ChartUtils.createDefaultPieDataset(categories, datas);
		return dataset;
	}

	public ChartPanel createChart() {
		// 2������Chart[������ͬͼ��]
		JFreeChart chart = ChartFactory.createPieChart("Contents of Highsoft's weekly fruit delivery", createDataset());
		// 3:���ÿ���ݣ���ֹ������ʾ�����
		ChartUtils.setAntiAlias(chart);// �����
		// 4:�����ӽ�����Ⱦ[������ͬͼ��]
		ChartUtils.setPieRender(chart.getPlot());
		/**
		 * ����ע�Ͳ���
		 */
		// plot.setSimpleLabels(true);//�򵥱�ǩ,����������
		// plot.setLabelGenerator(null);//����ʾ����
		// ���ñ�ע�ޱ߿�
		chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
		// ��עλ���Ҳ�
		chart.getLegend().setPosition(RectangleEdge.RIGHT);
		// 6:ʹ��chartPanel����
		ChartPanel chartPanel = new ChartPanel(chart);
		return chartPanel;
	}

	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 420);
		frame.setLocationRelativeTo(null);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// ����ͼ��
				ChartPanel chartPanel = new PieChart().createChart();
				frame.getContentPane().add(chartPanel);
				frame.setVisible(true);
			}
		});

	}

}
