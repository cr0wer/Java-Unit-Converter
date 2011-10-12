
import java.util.LinkedList;
import java.util.List;

// trida pro jednotky
final class Unit {

    private String name;
    private String comment;
    private double size;

    public Unit(String _name, String _comment, double _size) {
        name = _name;
        comment = _comment;
        size = _size;
    }

    public String getUnitName() {
        return name;
    }

    public String getUnitComment() {
        return comment;
    }

    public double getUnitSize() {
        return size;
    }
}

// prevodnik
final class Converter {

    // uchovava seznam vsech jednotek pres List<>
    private List<Unit> units = new LinkedList<Unit>();

    // podle nazvu jednotky ziska jeji pevnou hodnotu v metrech
    private double getUnitValue(String unitName) {
        for (Unit it : units) {
            if (it.getUnitName().equals(unitName)) {
                return it.getUnitSize();
            }
        }
        return Double.NaN;
    }

    // ziska celkovy pocet jednotek v seznamu
    public int getTotalUnits() {
        return units.size();
    }

    // vrati pole vsech jednotek - jejich nazvu (pro ComboBox)
    public String[] getAllUnitNames() {
        String buffer[] = new String[units.size()];
        int i = 0;

        for (Unit it : units) {
            buffer[i++] = it.getUnitName();
        }
        return buffer;
    }

    // vrati komentar k jednotce
    public String getUnitComment(String unitName) {
        for (Unit it : units) {
            if (it.getUnitName().equals(unitName)) {
                return it.getUnitComment();
            }
        }
        return null;
    }

    // prevede hodnotu z jednotky do pozadovane jednotky a vrati ji
    public double getConvertResult(double value, String from, String to) {
        Double fromVal = getUnitValue(from);
        Double toVal = getUnitValue(to);

        if (fromVal.isNaN() || toVal.isNaN()) {
            return Double.NaN;
        }
        return (value * fromVal) / toVal;
    }

    // umozni pridat jednotku do seznamu
    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
