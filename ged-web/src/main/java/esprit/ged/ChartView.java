package esprit.ged;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.time.Month;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import Service.ReclamationServicesLocal;
@ViewScoped
@ManagedBean
public class ChartView implements Serializable {
	@EJB
	private ReclamationServicesLocal rsl;
	private PieChartModel pieModel1;
	private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
     
   
     
    private void createPieModels() {
        createPieModel1();
        createAnimatedModels();
      
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Treated Reclamations",rsl.countTreated());
        pieModel1.set("UnTreated Reclamations ",rsl.countUntreated());
        pieModel1.set("Reclamations in Progress",rsl.countInProgress());
         
        pieModel1.setShowDataLabels(true);
        pieModel1.setTitle("Pie Chart");
        pieModel1.setLegendPosition("w");
    }
    
    
    
    private void createAnimatedModels() {
    	animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries r = new ChartSeries();
        r.setLabel("Reclamation Traité");
        for (int i = 1; i <= 12; i++) {
			
        r.set(Month.of(i).name(),rsl.countTreatedByMonth(i));
        }
 
       
 
        model.addSeries(r);
       
         
        return model;
    }
}