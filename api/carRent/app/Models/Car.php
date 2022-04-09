<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Car extends Model
{
    use HasFactory;
    protected $fillable =[
        "platenumber",
        "doornumber",
        "modelyear",
        "propulsion_id",
        "gearbox_id",
        "brand_id",
        "color_id"
    ];
    public $timestamps = false;
}
