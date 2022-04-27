<?php

namespace App\Http\Controllers;
use Validator;
use App\Models\Car;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
class CarController extends BaseController
{
    public function index(){
        try {
            $car=DB::table('cars')
            ->join('propulsions', 'cars.propulsion_id', '=', 'propulsions.id')
            ->join('gearboxes', 'cars.gearbox_id', '=', 'gearboxes.id')
            ->join('brands', 'cars.brand_id', '=', 'brands.id')
            ->join('colors', 'cars.color_id', '=', 'colors.id')
            ->select('cars.platenumber','cars.doornumber','cars.modelyear','propulsions.name as propulsion type','gearboxes.name as gearbox type','brands.name as brand','colors.name as color')
             ->get();
            return $this->sendResponse($car, "Autók betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Autók betöltése sikertelen", $th);
        }
    }
    public function create(Request $request){
        $validator = Validator::make($request->all(), [
            'platenumber' => 'required',
            'doornumber' => 'required',
            'modelyear' => 'required',
            'propulsion_id' =>'required',
            'gearbox_id' => 'required',
            'brand_id' => 'required',
            'color_id' => 'required'
        ]);
        if ($validator->fails()) {
            return $this->sendError("Hibás érvényesítés", $validator->errors());
        }
        try {
            $car = Car::create($request->all());
            return $this->sendResponse($car, "Autó létrehozása sikeres");
        } catch (\Throwable $th) {
            return $this->sendError("Autó létrehozása sikertelen", $th);
        }
    }
    public function show($id){
        try {
            $car=Car::find($id);
            return $this->sendResponse($car, "Autó betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Autó betöltése sikertelen", $th);
        }
    }
    public function update(Request $request,$id){
        try {
            $car=Car::find($id);
            $car->update( $request->all() );
            return $this->sendResponse($car, "Autó módosítása sikeres.");
        } catch (\Throwable $th) {
            return $this->sendError("Autó módosítása sikertelen", $th);
        }
    }
    public function delete($id){
        try {
            Car::destroy($id);
            return $this->sendResponse("", "Autó sikeresen törölve");
        } catch (\Throwable $th) {
            return $this->sendError("Autó törlése sikertelen", $th);
        }
    }
}
